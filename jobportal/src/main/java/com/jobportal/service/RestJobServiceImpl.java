package com.jobportal.service;

import java.util.List;

import javax.xml.ws.Response;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.jobportal.model.Jobs;
import com.jobportal.model.JobsApplied;

@Service
public class RestJobServiceImpl implements RestJobService {

	private RestTemplate restTemplate;

	private String stringurl;

	@Autowired
	public RestJobServiceImpl(RestTemplate theRest, @Value("${rest.url}") String url) {
		restTemplate = theRest;
		stringurl = url;

	}

	@Override
	public List<Jobs> getJobs() {

		ResponseEntity<List<Jobs>> responseEntity = restTemplate.exchange(stringurl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Jobs>>() {
				});

		List<Jobs> jobs = responseEntity.getBody();

		return jobs;
	}

	public Jobs postJobs(Jobs jobs) {

		restTemplate.postForObject(stringurl, jobs, Jobs.class);
		return jobs;

	}

	public List<Jobs> getJobByCompany(String company) {

		ResponseEntity<List<Jobs>> responseEntity = restTemplate.exchange(stringurl + "/" + company, HttpMethod.GET,
				null, new ParameterizedTypeReference<List<Jobs>>() {
				});
		List<Jobs> jobs = responseEntity.getBody();
		return jobs;
	}

	public List<String> getAllCompanies() {

		ResponseEntity<List<String>> re = restTemplate.exchange(stringurl + "/" + "companies", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<String>>() {
				});

		return re.getBody();

	}

	public void applyJob(JobsApplied jobs) {
		/*
		 * HttpEntity<JobsApplied> request = new HttpEntity<JobsApplied>(jobs);
		 * ResponseEntity<Jobs> response =
		 * restTemplate.exchange(stringurl+"/"+"applyJob", HttpMethod.POST,request,
		 * Jobs.class);
		 */
		/*
		 * OkHttpClient client = new OkHttpClient().newBuilder() .build(); MediaType
		 * mediaType = MediaType.parse("application/json"); RequestBody body =
		 * RequestBody.create(mediaType, "{\"jid\":6,\"userName\":\"yak229\"}"); Request
		 * request = new Request.Builder()
		 * .url("http://localhost:8083/getajob-rest/api/jobs/applyjob") .method("POST",
		 * body) .addHeader("Content-Type", "application/json") .build();
		 * 
		 * Response response = client.newCall(request).execute();
		 */

	}

}
