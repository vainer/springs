package vainerv.tutorial.spring.mongos.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import vainerv.tutorial.spring.mongos.exceptions.SequenceException;
import vainerv.tutorial.spring.mongos.model.Sequence;

@Repository
public class SequenceDao {

	@Autowired
	private MongoOperations mongoOperations;

	public Long getNextSequenceId(String key) {
		// получаем объект Sequence по наименованию коллекции
		Query query = new Query(Criteria.where("id").is(key));

		// увеличиваем поле sequence на единицу
		Update update = new Update();
		update.inc("sequence", 1);

		// указываем опцию, что нужно возвращать измененный объект
		FindAndModifyOptions options = new FindAndModifyOptions();
		options.returnNew(true);

		Sequence sequence = mongoOperations.findAndModify(query, update, options, Sequence.class);

		// if no sequence throws SequenceException
		if (sequence == null)
			throw new SequenceException("Unable to get sequence for key: " + key);

		return sequence.getSequence();
	}

}
