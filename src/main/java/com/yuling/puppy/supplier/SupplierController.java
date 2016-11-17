package com.yuling.puppy.supplier;

import com.yuling.puppy.supplier.dto.PageModel;
import com.yuling.puppy.supplier.dto.SupplierSearchBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yangyongli on 25/10/2016.
 */
@RestController
@RequestMapping("/supplier")
public class SupplierController {

    private final Logger logger = LoggerFactory.getLogger(SupplierController.class);

    @RequestMapping(value = "/query",
        method = {RequestMethod.GET, RequestMethod.POST},
        produces = MediaType.APPLICATION_JSON_VALUE)
    public PageModel query(@RequestBody SupplierSearchBean searchBean) {
        logger.debug("SupplierController.query by {}", searchBean);
        PageModel pageModel = new PageModel();
        return pageModel;
    }
}
