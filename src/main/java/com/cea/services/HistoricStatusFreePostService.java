package com.cea.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.cea.models.HistoricStatusFreePost;
import com.cea.repository.HistoricStatusFreePostRepository;

@Service
public class HistoricStatusFreePostService {

	@Autowired
	HistoricStatusFreePostRepository historicStatusFreePostRepository;

	/*
	 * INSERT
	 * */
	public HistoricStatusFreePost insert(HistoricStatusFreePost historicStatusFreePost) {

		return historicStatusFreePostRepository.save(historicStatusFreePost);

	}

	/*
	 * DELETE
	 * */
	public void delete(UUID id) {
		try {
			historicStatusFreePostRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Registro não encontrado com ID informado!");
		} catch (DataIntegrityViolationException e) {
			throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Esse registro não pode ser deletado!");
		}
	}

}
