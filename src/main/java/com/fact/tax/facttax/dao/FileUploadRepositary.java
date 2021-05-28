package com.fact.tax.facttax.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fact.tax.facttax.model.FileInformation;




public interface FileUploadRepositary extends JpaRepository<FileInformation, Integer>{

	@Query("from FileInformation a where a.fileType= ? and a.fileTypeId= ?")
	public List<FileInformation> findByFile(int fileType,Long fileTypeId);
	
    @Query("from FileInformation a where a.fileType= ? and a.fileTypeId= ? ")
    public FileInformation getSoftwareFileInformationById(int fileType,
            Long fileTypeId);

@javax.transaction.Transactional
@org.springframework.data.jpa.repository.Modifying
    @Query("delete from FileInformation  where fileType=? and fileTypeId=?")
    public void deleteFilesById(String fileType, Long fileTypeId);

    @Query("from FileInformation a where a.id= ? ")
    public FileInformation getFileInformation(Long id);
    
    

    
    
    
	
}
