package kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguages implements ProgrammingLanguageRepository{
	
	List<ProgrammingLanguage> programmingLanguages;
	
	
	public InMemoryProgrammingLanguages() {
		programmingLanguages = new ArrayList<ProgrammingLanguage>();
		programmingLanguages.add(new ProgrammingLanguage(1,"C#"));
		programmingLanguages.add(new ProgrammingLanguage(2,"Java"));
		programmingLanguages.add(new ProgrammingLanguage(3,"Python"));
	}


	@Override
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguages;
	}


	@Override
	public void add(ProgrammingLanguage programmingLanguage) {
		programmingLanguages.add(programmingLanguage);
		
	}

	@Override
	public void delete(int id) {
		ProgrammingLanguage programmingLanguage=getById(id);
		programmingLanguages.remove(programmingLanguage);
	}


	@Override
	public ProgrammingLanguage getById(int id) {
		for(ProgrammingLanguage programmingLanguage:programmingLanguages) {
			if(programmingLanguage.getId()==id) {
				return programmingLanguage;
			}
		}
		return null;
	}


	@Override
	public void update(ProgrammingLanguage programmingLanguage) {
		for(ProgrammingLanguage programmingLanguage1:programmingLanguages) {
			if(programmingLanguage1.getId()==programmingLanguage.getId()) {
				programmingLanguage1.setName(programmingLanguage.getName());
			}
		
			}
		
		
	}
	
	

}
