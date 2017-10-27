package de.gedoplan.whatsnewinjee8.persistence;

import de.gedoplan.baselibs.persistence.repository.SingleIdEntityRepository;
import de.gedoplan.whatsnewinjee8.entity.Document;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional(rollbackOn = Exception.class)
public class DocumentRepository extends SingleIdEntityRepository<Integer, Document> {

}
