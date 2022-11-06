package kodlama.io.Devs.business.concretes;

import java.util.List;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
	private ProgrammingLanguageRepository programmingLanguageRepository;
	
	
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;
	}



	@Override
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguageRepository.getAll() ;
	}


	@Override
	public void add(ProgrammingLanguage programmingLanguage)throws Exception { 
		
		if(programmingLanguage.getName().isEmpty()){
			throw new Exception("Kurs adı boş olamaz.");
		}
		
		for(ProgrammingLanguage programmingLanguages:getAll()) {
			if(programmingLanguage.getName().equals(programmingLanguages.getName())) {
	     		throw new Exception("Bu kurs ismi sistemde kayıtlıdır.Lütfen başka bir isim giriniz.");
			}
			if(programmingLanguages.getId() == programmingLanguage.getId()) {
				throw new Exception("Bu kurs Id'si sistemde kayıtlıdır.Lütfen başka bir Id giriniz.");
			}
		}
			programmingLanguageRepository.add(programmingLanguage);
		
	}

	@Override
	public void delete(int id) throws Exception{
		programmingLanguageRepository.delete(id);
			}
	

	@Override
	public ProgrammingLanguage getById(int id) {
		return programmingLanguageRepository.getById(id);
	}



	@Override
	public void update(ProgrammingLanguage programmingLanguage) {
		programmingLanguageRepository.update(programmingLanguage);
		
	}
	

  }

