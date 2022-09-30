package com.mgnrega.dao;

import java.util.List;

import com.mgnrega.been.BDO;
import com.mgnrega.been.GPM;
import com.mgnrega.been.Project;
import com.mgnrega.exception.BDOException;
import com.mgnrega.exception.GPMException;
import com.mgnrega.exception.ProjectException;

public interface MGNREGA {

	public BDO loginbdo(String usename,String password)throws BDOException;
	
	public GPM loginGPM(String usename,String password)throws GPMException;
	
	public String createproject(Project project);
	
	public String createnewGPM(GPM gpm);
	
	public String allocateprojecttoGPM(int pid,int gpmid)throws ProjectException, GPMException;
	
	public List<Project> listofProject()throws ProjectException;
	
	public List<GPM> listofGPM()throws GPMException;
	
	
	
}
