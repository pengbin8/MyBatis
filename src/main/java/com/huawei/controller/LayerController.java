package com.huawei.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.internal.Function;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huawei.model.Layer;
import com.huawei.model.UpdateLayer;
import com.huawei.service.LayerService;
import com.sun.tools.hat.internal.util.Comparer;

import ch.qos.logback.core.filter.Filter;

@RestController
public class LayerController {

	@Autowired
	private LayerService layerService;
	
	@RequestMapping(value="/gis/insertLayers",method=RequestMethod.POST)
	public boolean insertLayers(@RequestBody(required=true)
		ArrayList<Layer> layers) throws Exception {
		try {
			layerService.inseryLayers(layers);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			throw e;
		}
	}
	
	@RequestMapping(value="/gis/deleteLayers",method=RequestMethod.GET)
	public boolean deleteLayers(@RequestParam(required=true) ArrayList<Integer> ids) {
		return layerService.deleteLayers(ids);
	}
	
	@RequestMapping(value="/gis/getLayers",method=RequestMethod.GET)
	public List<Layer> getLayers() {
		return layerService.getLayers();
	}
	
	@RequestMapping(value="/gis/updateLayer",method=RequestMethod.POST)
	public boolean updateLayer(@RequestBody(required=true) UpdateLayer layer) {
		return layerService.updateLayer(layer);
	}
	
	public static void main(String[] args) {
		List<String> strs=new ArrayList<String>() ;
		strs.add("abcA");strs.add("acf");strs.add("acb");
		List<Object> sorted = strs.stream().sorted().peek(c->System.err.println("res="+c))
				.map(p->p.toUpperCase()).filter(c->c.endsWith("A")).collect(Collectors.toList());
		//System.out.println(sorted);
		Map<String, Long> groupby = strs.stream()
				.collect(Collectors.groupingBy(c->c,Collectors.counting()));
		//System.out.println(sorted);
		
		List<UpdateLayer> layers=new ArrayList<UpdateLayer>() ;
		layers.add(new UpdateLayer(1,"1","1","1"));
		layers.add(new UpdateLayer(5,"5","5","5"));
		layers.add(new UpdateLayer(3,"3","3","3"));
		layers.add(new UpdateLayer(4,"4","4","4"));
		layers.sort(Comparator.comparing(UpdateLayer::getId).reversed());
		for (UpdateLayer updateLayer : layers) {
			System.out.println(updateLayer.getId());
		}
		UpdateLayer updateLayer = layers.stream().sorted(Comparator.comparing(UpdateLayer::getId).reversed()).findFirst().get();
		System.out.println("stream="+updateLayer.getId());
		int res=function(4,v->v*2);
		//System.out.println(res);
		
	}
	
	public static int function(int a,Function<Integer ,Integer > fun) {
		return fun.apply(a);
	}
	
}
