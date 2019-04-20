# springboot-jpa

##主键查询
User user1 = userRepository.getOne(1L);
##是否存在的id
userRepository.existsById(1L);
##查询所有
List<User> all = userRepository.findAll();
##查询符合主键的所有
List<Long> a = new ArrayList<>();
a.add(1L);
a.add(2L);
List<User> allById = userRepository.findAllById(a);
##查询所有，id降序
List<User> id = userRepository.findAll(Sort.by("id").descending());
##分页根据id降序查询
Pageable pageable =PageRequest.of(1,1, Sort.Direction.DESC,"id");
Page<User> page = userRepository.findAll(pageable);
System.out.println("总页数："+page.getTotalPages()+"当前页："+page.getPageable().getPageNumber());
User user=null;
##保存或修改 立即 flush
userRepository.saveAndFlush(user);
##保存或修改
userRepository.save(user);
##批量保存
List<User> list=new ArrayList<>();
userRepository.saveAll(list);
##删除单个
userRepository.delete(user);
##删除所有，一条一条执行
userRepository.deleteAll();
##单个删除
userRepository.deleteAll(list);
##批量执行，一条语句
userRepository.deleteAllInBatch();
##根据主键删除
userRepository.deleteById(1l);
##批量删除
userRepository.deleteInBatch(list);
##统计所有行数
long count = userRepository.count();
##自定义方法的模糊查询
Page<User> admin4 = userRepository.findByUsernameLike("%admin%", PageRequest.of(0, 1, Sort.Direction.ASC, "username"));
##QueryByExampleExecutor 接口方法 findAll
User user2 = new User();
user2.setUsername("admin");
Example<User> example = Example.of(user2);
List<User> one = userRepository.findAll(example, Sort.by("username").descending());

##QueryByExampleExecutor 接口方法 findOne 
User user3 = new User();
user3.setId(1L);
Example<User> example1 = Example.of(user3);
Optional<User> user4 = userRepository.findOne(example1); 
##QueryByExampleExecutor 接口方法 count  
User user5 = new User();
user5.setId(1L);
Example<User> example2 = Example.of(user3); 
##QueryByExampleExecutor 接口方法 findAll 模糊查找   
User user6 = new User();
user6.setUsername("admin");
ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher("username", ExampleMatcher.GenericPropertyMatchers.startsWith());
Example<User> example3 = Example.of(user2,exampleMatcher);
List<User> one2 = userRepository.findAll(example3, Sort.by("username").descending());;
##根据hql查询用户名
User admin = userRepository.findByHQL("admin");
##根据sql查询用户名
User admin1 = userRepository.findBySQL("admin", "123456");
##根据用户名和密码查询
User admin2 = userRepository.findByUsernameAndPassword("admin", "123456");
##根据用户名查询
User admin3 = userRepository.findByUsername("admin");
