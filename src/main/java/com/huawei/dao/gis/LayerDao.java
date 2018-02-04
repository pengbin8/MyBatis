package com.huawei.dao.gis;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.huawei.model.Layer;
import com.huawei.model.UpdateLayer;

@Mapper
public interface LayerDao {
	//批量插入，批量刪除，查詢，更新
	boolean inseryLayers(ArrayList<Layer> layers);
	boolean deleteLayers(ArrayList<Integer> ids);
	List<Layer> getLayers();
	boolean updateLayer(UpdateLayer layer);
}
