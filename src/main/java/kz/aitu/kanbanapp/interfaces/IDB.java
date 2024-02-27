package kz.aitu.kanbanapp.interfaces;

import java.sql.Connection;

public interface IDB {
    Connection getConnection();
}