package sysImplementation;

import java.util.ArrayList;

import java.util.Iterator;

public class SoftwareCompany implements Iterable<String>, Cloneable, Comparable<SoftwareCompany> {

	private class Programmer {
		private String id;
		private ArrayList<Integer> projectList;

		public Programmer(String id, int pNum) {
			this.id = id;
			projectList = new ArrayList<Integer>();
			projectList.add(0, pNum);
		}

		public Programmer nextProject(int pNum) {
			boolean a = false;
			for (int t : projectList) {
				if (t == pNum) {
					a = true;
				}
			}
			if (a == false) {
				projectList.add(pNum);
			}
			return this;
		}

		/*
		 * Do not modify this method, otherwise you will not pass release/secret tests
		 */
		@Override
		public String toString() {
			return "Programmer [id=" + id + ", projectList=" + projectList + "]";
		}

	}

	private ArrayList<Programmer> programmerList;

	public SoftwareCompany() {
		this.programmerList = new ArrayList<Programmer>();
	}

	public int numberOfProgrammers() {
		return programmerList.size();
	}

	public SoftwareCompany addProgrammer(String id, int pNum) {
		boolean a = false;
		for (Programmer p : programmerList) {
			if (p.id == id) {
				a = true;
			}
		}
		if (a == false) {
			programmerList.add(new Programmer(id, pNum));
		}
		return this;
	}

	public SoftwareCompany newProject(String id, int pNum) {
		for (Programmer p : programmerList) {
			if (p.id == id) {
				p.nextProject(pNum);
				return this;
			}
		}
		return this;

	}

	@Override
	public SoftwareCompany clone() {
		SoftwareCompany obj = null;
		try {
			obj = (SoftwareCompany) super.clone();
			obj.programmerList = new ArrayList<Programmer>();
			for (Programmer p : this.programmerList) {
				int first = p.projectList.get(0);
				Programmer newp = new Programmer(p.id, first);
				for (int i = 1; i < p.projectList.size(); i++) {
					newp.nextProject(p.projectList.get(i));
				}
				obj.programmerList.add(newp);
			}

		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>() {
			private int pos = 0;

			public boolean hasNext() {
				return pos < programmerList.size();
			}

			public String next() {
				String pid = programmerList.get(pos).id;
				String number = "";
				for (int i = programmerList.get(pos).projectList.size() - 1; i >= 0; i--) {
					if (Integer.toString(programmerList.get(pos).projectList.get(i)).charAt(0) != '8') {
						number = Integer.toString(programmerList.get(pos).projectList.get(i));
						break;
					} else {
						number = "0";
					}
				}
				pos++;
				return pid + " " + number + "\n";

			}
		};
	}

	/*
	 * Do not modify this method, otherwise you will not pass release/secret tests
	 */
	@Override
	public String toString() {
		return "SoftwareCompany [programmerList=" + programmerList + "]";
	}

	@Override
	public int compareTo(SoftwareCompany o) {
		int k = 0;
		int l = 0;
		for (Programmer p : this.programmerList) {
			k += p.projectList.size();
		}
		for (Programmer s : o.programmerList) {
			l += s.projectList.size();
		}
		return k - l;

	}

}