# springboot-jpa

//主键查询
        User user1 = userRepository.getOne(1L);
        //是否存在的id
        userRepository.existsById(1L);
        //查询所有
        List<User> all = userRepository.findAll();

        //查询符合主键的所有
        List<Long> a = new ArrayList<>();
        a.add(1L);
        a.add(2L);
        List<User> allById = userRepository.findAllById(a);

        //查询所有，id降序
        List<User> id = userRepository.findAll(Sort.by("id").descending());


        //分页根据id降序查询
        Pageable pageable =PageRequest.of(1,1, Sort.Direction.DESC,"id");
        Page<User> page = userRepository.findAll(pageable);
        System.out.println("总页数："+page.getTotalPages()+"当前页："+page.getPageable().getPageNumber());
        log.debug("save or update--------------------------------");
        User user=null;
        //保存或修改 立即 flush
        userRepository.saveAndFlush(user);

        //保存或修改
        userRepository.save(user);

        //批量保存
        List<User> list=new ArrayList<>();
        userRepository.saveAll(list);

        log.debug("delete--------------------------------");
        userRepository.delete(user);
        //删除所有，一条一条执行
        userRepository.deleteAll();
        //单个删除
        userRepository.deleteAll(list);
        //批量执行，一条语句
        userRepository.deleteAllInBatch();
        //根据主键删除
        userRepository.deleteById(1l);
        //批量删除
        userRepository.deleteInBatch(list);
        //统计所有行数
        long count = userRepository.count();
        //自定义方法
        //模糊查询
        Page<User> admin4 = userRepository.findByUsernameLike("%admin%", PageRequest.of(0, 1, Sort.Direction.ASC, "username"));
        log.info(admin4.getTotalPages() + "");
        // log.debug("QueryByExampleExecutor 接口方法--------------------------------");
        /*<S extends T> Optional<S> findOne(Example<S> var1);
        <S extends T> Iterable<S> findAll(Example<S> var1);
        <S extends T> Iterable<S> findAll(Example<S> var1, Sort var2);
        <S extends T> Page<S> findAll(Example<S> var1, Pageable var2);
        <S extends T> long count(Example<S> var1);
        <S extends T> boolean exists(Example<S> var1);*/
        log.debug("findAll--------------------------------------");
        User user2 = new User();
        user2.setUsername("admin");
        Example<User> example = Example.of(user2);
        List<User> one = userRepository.findAll(example, Sort.by("username").descending());
        log.info("findAll:" + one.size());

        log.debug("findOne---------------------------------");
        User user3 = new User();
        user3.setId(1L);
        Example<User> example1 = Example.of(user3);
        Optional<User> user4 = userRepository.findOne(example1);
        log.info("findOne:" + user4.get().getPassword());

        log.debug("count---------------------------------");
        User user5 = new User();
        user5.setId(1L);
        Example<User> example2 = Example.of(user3);
        long count1 = userRepository.count(example2);
        log.info("count:" + count1);

        log.debug("findAll 模糊查找--------------------------------------");
        User user6 = new User();
        user6.setUsername("admin");
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher("username", ExampleMatcher.GenericPropertyMatchers.startsWith());
        Example<User> example3 = Example.of(user2,exampleMatcher);
        List<User> one2 = userRepository.findAll(example3, Sort.by("username").descending());
        log.info("findAll 模糊查找:" + one2.size());


        //根据hql查询用户名
        User admin = userRepository.findByHQL("admin");
        log.debug("根据hql查询用户名:" + admin.getUsername());

        //根据sql查询用户名
        User admin1 = userRepository.findBySQL("admin", "123456");
        System.out.println("根据sql查询用户名:" + admin1.getUsername());
        log.debug("根据sql查询用户名:" + admin1.getUsername());
        //根据用户名和密码查询
        User admin2 = userRepository.findByUsernameAndPassword("admin", "123456");

        log.debug("根据用户名和密码查询:" + admin2.getUsername());
        //根据用户名查询
        User admin3 = userRepository.findByUsername("admin");
        log.debug("根据用户名查询:" + admin3.getUsername());
