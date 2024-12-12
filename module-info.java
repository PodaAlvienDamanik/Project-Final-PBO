module RestoranApp {
    requires spring.context;
    requires spring.beans;
    requires java.sql;
    requires org.slf4j;

    opens RestoranApp;
    opens RestoranApp.config;
    opens RestoranApp.entities;
    opens RestoranApp.repository;
    opens RestoranApp.service;
    opens RestoranApp.views;
}