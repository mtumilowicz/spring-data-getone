[![Build Status](https://travis-ci.com/mtumilowicz/spring-data-getone.svg?branch=master)](https://travis-ci.com/mtumilowicz/spring-data-getone)
# spring-data-getone
The main goal of this project is to show how `getOne` works internally.

# preface
According to JPA specification, we have two methods:
* `EntityManager.find()` - query the database.
* `EntityManager.getReference()` - load proxy (no database query), 
    throws `EntityNotFoundException` if entity doesn't exist in the database 
    (when synchronization with the database occurs).
    
# spring data
* `Optional<T> findById(ID id)` - eager loading (internally `EntityManager.find()`)
* `T getOne(ID id)` - lazy loading (internally `EntityManager.getReference()`)

# project description
We enable query logging (`application.properties`):
```
spring.jpa.properties.hibernate.show_sql=true
```

and in `AppRunner` we simulate basic behaviour.

# remarks
If you use `getOne` it loads proxy, but at first reference to any field - 
provider loads the actual entity from database - so you have to still be
in the persistence context.

# tests
**Coverage**: `96%`
