package com.novelbio.omimdb.mgmt;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.novelbio.omimdb.model.GeneMIM;
import com.novelbio.omimdb.mongorepo.RepoGeneMIMInfo;
import com.novelbio.springonly.factory.SpringFactory;

public class MgmtGeneMIMInfo {
	private MgmtGeneMIMInfo() {}
	RepoGeneMIMInfo repoGeneMIMInfo = (RepoGeneMIMInfo)SpringFactory.getBean("repoGeneMIMInfo");
	public List<GeneMIM> findByGenMimId(int geneMimId){
		return repoGeneMIMInfo.findInfByGeneMimId(geneMimId);
	}
	public List<GeneMIM> findAll(){
		return repoGeneMIMInfo.findAll();
	}
	public void save(GeneMIM phenMimId){
		repoGeneMIMInfo.save(phenMimId);
	}
	//懒汉模式的单例延迟--超牛逼
	static class MgmtOmimHolder {
		static MgmtGeneMIMInfo mgmtGeneOMIM = new MgmtGeneMIMInfo();
	}
	/** 
	 * 获得
	 * @return
	 */
	public static MgmtGeneMIMInfo getInstance() {
		return MgmtOmimHolder.mgmtGeneOMIM;
	}
}