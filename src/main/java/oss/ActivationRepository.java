package oss;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ActivationRepository extends PagingAndSortingRepository<Activation, Long>{

    List<Activation> findByOrderId(Long orderId);
}