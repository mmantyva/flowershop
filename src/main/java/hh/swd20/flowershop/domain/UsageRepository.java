package hh.swd20.flowershop.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UsageRepository extends CrudRepository<Usage, String> {

	List<Usage> findByUse(String use);
}
