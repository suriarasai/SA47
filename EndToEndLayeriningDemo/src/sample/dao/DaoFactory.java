package sample.dao;

public class DaoFactory {

	

	public static UserDao getUserDao() {
		UserDao udao = new UserDaoImpl();
		return udao;
	}


	public static HeroDAO getHeroDAO() {
		return new HeroDAOImpl();
	}

}
