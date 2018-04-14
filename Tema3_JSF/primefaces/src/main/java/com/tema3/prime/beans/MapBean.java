package com.tema3.prime.beans;

import java.io.Serializable;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import com.tema3.prime.utils.DatabaseConnection;

@ManagedBean(name = "mapBean")
public class MapBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private MapModel mapModel = new DefaultMapModel();

	@PostConstruct
	public void testMap() {
		testDatabase();

	}

	public void testDatabase() {
		String connectionName = "useful-airlock-196617:europe-west1:tema3database";
		String databaseName = "tema3";
		String username = "root";
		String password = "qweasdzxc";
		try {
			DatabaseConnection.getMySQLDatabaseConnection(connectionName, databaseName, username, password);
		} catch (SQLException e) {
			Marker marker = new Marker(new LatLng(47.157223, 27.5882597));
			mapModel.addOverlay(marker);
			e.printStackTrace();
		}
	}

	public void onPointSelect(PointSelectEvent event) {
		LatLng latLng = event.getLatLng();

		System.out.println(latLng);
	}

	public MapModel getMapModel() {
		return mapModel;
	}
}
