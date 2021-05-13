## GraphQL Conception

- Graph 表示不同数据之间的关系:

![img](https://www.apollographql.com/blog/static/c4924ed95eff90b5e63d3ac22a9eeddf/1_EmhOknzZEu9Q6U3q5NmT9Q.png)

- 通过Query来获取数据

```shell
query {
  book(isbn: "9780674430006") {
    title 
    authors {
      name
    }
  }
}
```

- 返回结果

```shell
{
  book: {
    title: “Capital in the Twenty First Century”,
    authors: [
      { name: ‘Thomas Piketty’ },
      { name: ‘Arthur Goldhammer’ },
    ]
  }
}
```

- data graph

![img](https://www.apollographql.com/blog/static/61a0272931a147c4ce6ec646e88f75b1/1_9ZFclOcI4mvp4j4bymi8cQ.png)
![img](https://www.apollographql.com/blog/static/4f7be8cbf06bbd56c00a9b4ea80d206e/1_ze1LAOQN-4sQJQ4p3mdkNw.png)

- Two Queries

```shell
query particularAuthor {
  author(name: "Thomas Piketty") {
    name
    age
  }
}

query authorAndBook {
  book(isbn: "9780674430006") {
    title
  }  author(name: "Thomas Piketty") {
    name
    age
  }
}
```



