package vainerv.tutorial.spring.mongos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vainerv.tutorial.spring.mongos.dao.ContactDao;
import vainerv.tutorial.spring.mongos.dao.SequenceDao;
import vainerv.tutorial.spring.mongos.model.Contact;

@Service
public class ContactService {

	@Autowired
	private ContactDao contactDao;

	@Autowired
	private SequenceDao sequenceDao;

	public void add(Contact contact) {
		contact.setId(sequenceDao.getNextSequenceId(Contact.COLLECTION_NAME));
		contactDao.save(contact);
	}

	public void update(Contact contact) {
		contactDao.save(contact);
	}

	public Contact get(Long id) {
		return contactDao.get(id);
	}

	public List<Contact> getAll() {
		return contactDao.getAll();
	}

	public void remove(Long id) {
		contactDao.remove(id);
	}

}
