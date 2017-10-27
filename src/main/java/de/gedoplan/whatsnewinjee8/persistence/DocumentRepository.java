package de.gedoplan.whatsnewinjee8.persistence;

import de.gedoplan.baselibs.persistence.repository.SingleIdEntityRepository;
import de.gedoplan.whatsnewinjee8.entity.Document;

import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional(rollbackOn = Exception.class)
public class DocumentRepository extends SingleIdEntityRepository<Integer, Document> {

  public Stream<Document> findAllAsStream() {

    return this.entityManager
        .createQuery("select x from Document x", Document.class)
        .getResultStream();
  }

}
