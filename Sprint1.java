//Yifan Shi
//US03
	public boolean comparaDeath(String temp) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date birthday = sdf.parse("02/02/1956");
		Date deathday = sdf.parse("03/04/2011");
		if(birthday.compareTo(deathday)<0) {
			return true;
		}else if (birthday.compareTo(deathday)>0) {
			return false;
		}else if (birthday.compareTo(deathday)==0) {
			return false;
		}
		return false;
 	} 
	//US02
	public boolean comparaMarry(String temp) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date birthday = sdf.parse("02/02/1956");
		Date marryday = sdf.parse("03/04/1980");
		if(birthday.compareTo(marryday)<0) {
			return true;
		}else if (birthday.compareTo(marryday)>0) {
			return false;
		}else if (birthday.compareTo(marryday)==0) {
			return false;
		}
		return false;
 	} 