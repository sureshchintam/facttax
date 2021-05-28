package com.fact.tax.facttax.service;

import com.fact.tax.facttax.io.PathInformation;
import com.fact.tax.facttax.io.Resource;

public interface FileService {

	
	 /**
     * Stores given stream in file system with given path. If any file exists with given name, it'll replace name
     * with generated one.
     *
     * @return saved file's relative path.
     */
    PathInformation save(Resource resource, PathInformation pathInformation);

    /**
     * Stores given stream in file system with given path. If any file exists with given name and overwrite is false,
     * it'll replace name  with generated one.
     *
     * @param overwrite whether to overwrite existing one or creates new one.
     * @return saved file's relative path.
     */
    PathInformation save(Resource resource, boolean overwrite);

    default PathInformation save(Resource resource) {
        return save(resource, false);
    }


    Resource getFile(String relativePath);
	
}
