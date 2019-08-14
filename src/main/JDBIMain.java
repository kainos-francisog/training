package main;

import main.data.City;
import main.data.WorldMapper;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import java.util.List;

public class JDBIMain {


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        var jdbi = Jdbi.create("jdbc:mysql://localhost/world", "worlduser", "worldPwd!");
        jdbi.installPlugin(new SqlObjectPlugin());

        City belfast = jdbi.withHandle(handle -> {
            WorldMapper mapper = handle.attach(WorldMapper.class);
            return mapper.getCity(469);
        });
        System.out.println(belfast.getName()
                + " has a population of "
                + belfast.getPopulation());

        List<City> walesCities = jdbi.withHandle(handle -> {
            WorldMapper mapper = handle.attach(WorldMapper.class);
            return mapper.getCitiesForDistrict("wales");
        });
        for (var city : walesCities) {
            System.out.println(city.getName()
                    + " has a population of "
                    + city.getPopulation());
        }
    }


}
