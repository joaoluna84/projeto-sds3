package com.devsuperior.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{
	
	@Query("SELECT new com.devsuperior.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) "
	        + " FROM com.devsuperior.dsvendas.entities.Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupedBySeller();
		
	//SELECT (obj.seller_id, SUM(obj.visited), SUM(obj.deals))  FROM TB_SALES AS obj GROUP BY obj.seller_id;
	@Query("SELECT new com.devsuperior.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
	        + " FROM com.devsuperior.dsvendas.entities.Sale AS obj GROUP BY obj.seller")
	List<SaleSuccessDTO> successGroupedBySeller();

}
