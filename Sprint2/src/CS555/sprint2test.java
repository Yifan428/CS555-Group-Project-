package CS555;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class sprint2test {

	@Test
	void test() {
//		fail("Not yet implemented");
		 Individual I =new Individual();
		 I.setBirthDate("1934-10-19");
		 I.setMarriageDate("1960-08-28");
		 I.setDeathDate("2009-10-19");
		 assert(I.birthDate!=null);
		 assert(I.deathDate!=null);
		 assert(I.marriageDate!=null);
	}

}
