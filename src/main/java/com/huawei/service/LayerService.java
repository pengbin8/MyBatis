package com.huawei.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huawei.dao.gis.LayerDao;
import com.huawei.model.Layer;
import com.huawei.model.UpdateLayer;

@Service
public class LayerService {
	
	@Autowired
	private LayerDao layerDao;
	
	public boolean inseryLayers(ArrayList<Layer> layers) {
		return layerDao.inseryLayers(layers);
	}
	public boolean deleteLayers(ArrayList<Integer> ids) {
		return layerDao.deleteLayers(ids);
	}
	public List<Layer> getLayers(){
		return layerDao.getLayers();
	}
	public boolean updateLayer(UpdateLayer layer) {
		return layerDao.updateLayer(layer);
	}
}
