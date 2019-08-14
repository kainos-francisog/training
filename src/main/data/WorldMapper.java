package main.data;
import java.util.List;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

public interface WorldMapper {
	
	@SqlQuery("SELECT ID, Name, Population, District, CountryCode FROM city WHERE CountryCode = ?")
	@RegisterBeanMapper(City.class)
	List<City> getCitiesForCountry(String code);
	
	@SqlQuery("SELECT ID, Name, Population, CountryCode FROM city WHERE ID = ?")
	@RegisterBeanMapper(City.class)
	City getCity(int ID);
	
	@SqlQuery("SELECT Code, Name, Region, Continent FROM country WHERE Code= ?")
	@RegisterBeanMapper(Country.class)
	Country getCountry(String code);

	@SqlQuery("SELECT DISTINCT Continent FROM country ORDER BY 1")
	List<String> getContinents();
	
	@SqlQuery("SELECT DISTINCT Region, Continent FROM country WHERE Continent=? ORDER BY 1")
	List<String> getRegionsForContinent(String continent);
	
	@SqlQuery("SELECT Code, Name, Region, Continent FROM country WHERE region=? ORDER BY 2")
	@RegisterBeanMapper(Country.class)
	List<Country> getCountriesForRegion(String region);
	
	@SqlQuery("SELECT ID, Name, Population, District, CountryCode FROM city WHERE District=?")
	@RegisterBeanMapper(City.class)
	List<City> getCitiesForDistrict(String district);
	
	@SqlQuery("SELECT DISTINCT District FROM city WHERE CountryCode=? ORDER BY 1")
	List<String> getDistrictsForCountry(String code);

	
}
