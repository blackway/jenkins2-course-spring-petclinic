/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.web;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Vets;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Juergen Hoeller
 * @author Mark Fisher
 * @author Ken Krebs
 * @author Arjen Poutsma
 */
@RestController
public class VetRestController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
    private final ClinicService clinicService;
    
    @Autowired
    public VetRestController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }
    
//    @RequestMapping(value = "/test", method = RequestMethod.GET)
//    public RestTest testRestAPI() {
//        RestTest test = new RestTest();
//        test.setName("codingsquid");
//        test.setAge(25);
//        test.setCurrentTime(LocalDateTime.now().toString());
//        return test;
//    }

//    @RequestMapping(value = { "/rest/vets.html"})
//    public String showVetList(Map<String, Object> model) {
//        // Here we are returning an object of type 'Vets' rather than a collection of Vet objects
//        // so it is simpler for Object-Xml mapping
//        Vets vets = new Vets();
//        vets.getVetList().addAll(this.clinicService.findVets());
//        model.put("vets", vets);
//        return "vets/vetList";
//    }
    
    @RequestMapping(value = { "/rest/vets2"})
//    @ResponseBody
    public Vets showVetList2(Map<String, Object> model) {
    	// Here we are returning an object of type 'Vets' rather than a collection of Vet objects
    	// so it is simpler for Object-Xml mapping
    	Vets vets = new Vets();
    	vets.getVetList().addAll(this.clinicService.findVets());
    	return vets;
    }

    @RequestMapping(value = { "/rest/vets"})
//    @ResponseBody
    public String showVetList(Map<String, Object> model) {
    	// Here we are returning an object of type 'Vets' rather than a collection of Vet objects
    	// so it is simpler for Object-Xml mapping
    	Vets vets = new Vets();
    	vets.getVetList().addAll(this.clinicService.findVets());
//    	model.put("vets", vets);
    	ObjectMapper mapper = new ObjectMapper();
    	
    	String jsonString = null;
    	try {
    		jsonString = mapper.writeValueAsString(vets);
    	} catch (JsonProcessingException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	return jsonString;
    }
    
    @RequestMapping(value = { "/rest/vets.json", "/rest/vets.xml"})
//    @ResponseBody
    public Vets showResourcesVetList() {
        // Here we are returning an object of type 'Vets' rather than a collection of Vet objects
        // so it is simpler for JSon/Object mapping
        Vets vets = new Vets();
        vets.getVetList().addAll(this.clinicService.findVets());
        logger.info(" @@@@@ vets.getVetList() : " +vets.getVetList().size());
        logger.info(" @@@@@ vets : " +vets);
        return vets;
    }


}
