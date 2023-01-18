package repositories;


import com.datastax.oss.driver.api.core.CqlSession;
import dao.ParentDao;
import dao.ReservationDao;
import dao.SitterDao;
import mappers.*;
import model.Parent;
import model.Reservation;
import model.Sitter;
import com.datastax.oss.driver.api.core.cql.Row;

import com.datastax.oss.driver.api.core.cql.ResultSet;

public abstract class AbstractRepository<T> implements ParentDao, SitterDao, ReservationDao {
    protected CqlSession session;
    protected ParentMapper parentMapper;
    protected ParentDao parentDao;
    protected SitterMapper sitterMapper;
    protected SitterDao sitterDao;
    protected ReservationMapper reservationMapper;
    protected ReservationDao reservationDao;

    public AbstractRepository(CqlSession session) {
        this.session = session;
        this.parentMapper = new ParentMapperBuilder(session).build();
        this.sitterMapper = new SitterMapperBuilder(session).build();
        this.reservationMapper = new ReservationMapperBuilder(session).build();
        this.sitterDao = sitterMapper.sitterDao();
        this.parentDao = parentMapper.parentDao();
        this.reservationDao = reservationMapper.reservationDao();
    }
//PARENT
    @Override
    public void createParent(Parent parent) {
        parentDao.createParent(parent);
    }

    @Override
    public Parent readParent(ResultSet resultSet) {
        return parentDao.readParent(resultSet);
    }

    @Override
    public void updateParent(Parent parent) {
        parentDao.updateParent(parent);
    }

    @Override
    public void deleteParent(Parent parent) {
        parentDao.deleteParent(parent);
    }
//SITTER
    @Override
    public void createSitter(Sitter sitter) {
        sitterDao.createSitter(sitter);
    }

    @Override
    public Sitter readSitter(ResultSet resultSet) {
        return sitterDao.readSitter(resultSet);
    }

    @Override
    public void updateSitter(Sitter sitter) {
        sitterDao.updateSitter(sitter);
    }

    @Override
    public void deleteSitter(Sitter sitter) {
        sitterDao.deleteSitter(sitter);
    }
//RESERVATION
    @Override
    public void createReservation(Reservation reservation) {
        reservationDao.createReservation(reservation);
    }

    @Override
    public Reservation readReservation(ResultSet resultSet) {
        return reservationDao.readReservation(resultSet);
    }

    @Override
    public void updateReservation(Reservation reservation) {
        reservationDao.updateReservation(reservation);
    }

    @Override
    public void deleteReservation(Reservation reservation) {
        reservationDao.deleteReservation(reservation);
    }

    protected  abstract T rowToEntity(Row row);
}