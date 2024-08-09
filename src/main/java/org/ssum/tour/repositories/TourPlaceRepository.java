package org.ssum.tour.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.ssum.tour.entities.TourPlace;

public interface TourPlaceRepository extends JpaRepository<TourPlace, Long>, QuerydslPredicateExecutor<TourPlace> {
}
