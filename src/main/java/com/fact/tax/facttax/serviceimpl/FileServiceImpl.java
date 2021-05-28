//package com.fact.tax.facttax.serviceimpl;
//
//import org.apache.commons.lang3.RandomStringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.fact.tax.facttax.dao.FileRepository;
//import com.fact.tax.facttax.io.PathInformation;
//import com.fact.tax.facttax.io.Resource;
//import com.fact.tax.facttax.service.FileService;
//
//
//
//@Service
//public class FileServiceImpl implements FileService {
//
//    @Autowired
//    private FileRepository repository;
//
//    @Override
//    public PathInformation save(final Resource resource, final PathInformation pathInformation) {
//        return repository.save(resource, pathInformation);
//    }
//
//    @Override
//    public PathInformation save(final Resource resource, final boolean overwrite) {
//
//        String fileName = overwrite ? resource.getName() : getUniqueName(resource.getName());
//
//        PathInformation pathInformation = new PathInformation(fileName);
//        return save(resource, pathInformation);
//    }
//
//    @Override
//    public Resource getFile(final String relativePath) {
//        return repository.getFileResource(relativePath);
//    }
//
//    private String getUniqueName(String fileName) {
//        String newName = fileName;
//        if (repository.exists(newName)) {
//            PathInformation pathInformation = new PathInformation(newName);
//            newName = RandomStringUtils.randomAlphabetic(12) + pathInformation.getExtension();
//
//            // checking recursively to find unique name
//            newName = getUniqueName(newName);
//        }
//        return newName;
//    }
//
//}
