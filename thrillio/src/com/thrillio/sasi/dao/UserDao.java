package com.thrillio.sasi.dao;

import com.thrillio.sasi.datastore.DataStore;
import com.thrillio.sasi.entities.User;

public class UserDao {
	public User[] getUsers() {
		return DataStore.getUsers();
	}
}
