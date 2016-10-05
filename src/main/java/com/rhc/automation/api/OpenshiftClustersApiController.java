package com.rhc.automation.api;

import com.rhc.automation.model.OpenShiftCluster;
import com.rhc.automation.model.ErrorModel;

import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-05T12:23:04.865-07:00")

@Controller
public class OpenshiftClustersApiController implements OpenshiftClustersApi {

	private ApiService apiService;

	public OpenshiftClustersApiController(ApiService apiService) {
	        this.apiService = apiService;
	    }

	public ResponseEntity<Void> addOpenShiftCluster(
			@ApiParam(value = "OpenShiftCluster object that needs to be added to the store") @RequestBody OpenShiftCluster body) {

		return apiService.add(body);
	}

	public ResponseEntity<Void> deleteOpenShiftCluster(
			@ApiParam(value = "OpenShiftCluster id to delete", required = true) @PathVariable("id") Long id) {

		return apiService.delete(OpenShiftCluster.class, id);
	}

	public ResponseEntity<List<OpenShiftCluster>> openshiftClustersGet(
			@ApiParam(value = "number of results to return") @RequestParam(value = "size", required = false) Integer size,
			@ApiParam(value = "offset in list") @RequestParam(value = "offset", required = false) Long offset) {

		List<OpenShiftCluster> clusterList = apiService.getList(size, offset, OpenShiftCluster.class);
		return new ResponseEntity<List<OpenShiftCluster>>(clusterList, HttpStatus.OK);
	}

	public ResponseEntity<OpenShiftCluster> openshiftClustersIdGet(
			@ApiParam(value = "OpenShiftCluster ID", required = true) @PathVariable("id") Long id) {

		return apiService.get(id, OpenShiftCluster.class);
	}

	public ResponseEntity<Void> updateOpenShiftCluster(
			@ApiParam(value = "OpenShiftCluster ID", required = true) @PathVariable("id") Long id,
			@ApiParam(value = "OpenShiftCluster object that needs to be updated in the store") @RequestBody OpenShiftCluster body) {

		return apiService.update(id, body);
	}
}