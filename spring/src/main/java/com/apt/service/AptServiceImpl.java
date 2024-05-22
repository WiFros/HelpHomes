package com.apt.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apt.mapper.AptMapper;
import com.apt.trie.Trie;
import com.apt.trie.TrieNode;
import com.apt.vo.AptDeal;
import com.apt.vo.DongCode;

import jakarta.annotation.PostConstruct;


@Service
public class AptServiceImpl implements AptService{
	@Autowired
	AptMapper mapper;//<- proxy가 주입됨

	@Autowired
	Trie trie;

	@PostConstruct
	public void initializeTrie() {
        List<DongCode> locations = mapper.findAllLocation();
        for (DongCode location : locations) {
            trie.insert(location.getSidoName(), location.getGugunName(), location.getDongName());
        }
    }
	@Override
	public List<AptDeal> search(String year, String month) throws SQLException {
		Map<String, String> map = new HashMap<>();
		map.put("year", year);
		map.put("month", month);
		return mapper.search(map);
	}
	
	@Override
	public List<AptDeal> dongSearch(String dongName, String year, String month) throws SQLException {
		Map<String, String> map = new HashMap<>();
		map.put("year", year);
		map.put("month", month);
		map.put("dongName", dongName);
		return mapper.dongSearch(map);
	}

	@Override
	public List<AptDeal> aptSearch(String aptName, String year, String month) throws SQLException {
		Map<String, String> map = new HashMap<>();
		map.put("year", year);
		map.put("month", month);
		map.put("aptName", aptName);
		return mapper.aptSearch(map);
	}
	

	@Override
	public List<AptDeal> aptFloorSearch(String aptCode, String floor) throws SQLException {
	    Map<String, String> map = new HashMap<>();
	    map.put("aptCode", aptCode);
	    map.put("floor", floor);
	    return mapper.aptFloorSearch(map);
	}


	public List<String> getSidoList() {
        TrieNode root = trie.getRoot();
        return new ArrayList<>(root.getChildren().keySet());
    }

    public List<String> getGugunList(String sido) {
        TrieNode node = trie.search(sido);
        if (node != null) {
            return new ArrayList<>(node.getChildren().keySet());
        }
        return new ArrayList<>();
    }

    public List<String> getDongList(String sido, String gugun) {
        TrieNode node = trie.search(sido, gugun);
        if (node != null) {
            return new ArrayList<>(node.getChildren().keySet());
        }
        return new ArrayList<>();
    }

}
