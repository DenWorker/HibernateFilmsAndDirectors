package org.DDD;

import Models.Director;
import Models.Film;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Director.class).addAnnotatedClass(Film.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Film film = session.get(Film.class, 2);
            System.out.println(film);

            Director director = session.get(Director.class, 1);
            System.out.println(director);

            director.getListOfFilms().forEach(System.out::println);

            session.getTransaction();
        } finally {
            sessionFactory.close();
        }
    }
}
