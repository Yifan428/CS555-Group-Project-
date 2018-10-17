package CS555;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Vector;

import org.junit.jupiter.api.Test;


class datatest {

	@Test
	void test() {
//		fail("Not yet implemented");
		 Individual I =new Individual();
		 I.setBirthDate("1986");
		 I.setDeathDate("2018-10");
		 assert(I.birthDate!=null);
		 assert(I.deathDate!=null);
		 int findword = function_z.findwhichline("@F2@");
		 assert(findword == 23);
	}

}
