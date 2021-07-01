package sysImplementation;

import java.util.Comparator;

public class SCComparator implements Comparator<SoftwareCompany> {

	public int compare(SoftwareCompany sc1, SoftwareCompany sc2) {
		return sc1.numberOfProgrammers() - sc2.numberOfProgrammers();
	}

}
