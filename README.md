# API接口列表

## 注册接口

### 用户注册

+ 接口：`/api/register`
+ 调用要求：无
+ 方法：POST
+ 请求类型：`application/json`
+ 参数含义：
+ 调用示例：
```bash
http://localhost:8080/api/register

# 发送的数据
# username: "lg"
# password: "helloworld"
```
+ 返回示例

```bash
{
  "statusCode": 200,
  "statusInfo": "OK",
  "data": []
}
```

## 登录接口

### 用户登录

+ 接口：`/api/login`
+ 调用要求：HTTP基本认证
+ 方法：POST
+ 请求类型：`application/json`
+ 参数含义：
+ 调用示例：
```bash
http://localhost:8080/api/login

# 发送的数据
# username: "lg"
# password: "helloworld"
```

## 首页接口

### 获取电影列表

+ 接口：`/api/index/get-movie-list`
+ 调用要求：无
+ 方法：GET
+ 请求类型：`application/json`
+ 参数含义：
+ 调用示例：

```bash
http://localhost:8080/api/index/get-movie-list
```
+ 返回示例

```bash
{
  "statusCode": 200,
  "statusInfo": "OK",
  "data": [
    {
      "id": 1,
      "imageUrl": "https://img3.doubanio.com/view/photo/photo/public/p480770143.jpg",
      "name": "肖申克的救赎",
      "hot": 9
    }
  ]
}
```

## 电影详情页接口

### 获取电影详情

+ 接口：`/api/movie-info/get-movie-info`
+ 调用要求：无
+ 方法：GET
+ 请求类型：`application/json`
+ 参数含义：
`movie_id`：电影的id
+ 调用示例：

```bash
http://localhost:8080/api/movie-info/get-movie-info?movie_id=1
```
+ 返回示例

```bash
{
  "statusCode": 200,
  "statusInfo": "OK",
  "data": {
    "movie": {
      "id": 1,
      "imgUrl": "https://img3.doubanio.com/view/photo/photo/public/p480770143.jpg",
      "name": "肖申克的救赎",
      "premiereTime": "1994-10-14",
      "duration": "142分",
      "type": "剧情/犯罪",
      "region": "欧美",
      "hot": 9,
      "description": "20世纪40年代末，小有成就的青年银行家安迪（蒂姆·罗宾斯 Tim Robbins 饰）因涉嫌杀害妻子及她的情人而锒铛入狱。在这座名为肖申克的监狱内，希望似乎虚无缥缈，终身监禁的惩罚无疑注定了安迪接下来灰暗绝望的人生。"
    },
    "actors": [
      {
        "id": 1,
        "zhName": "弗兰克·德拉邦特",
        "enName": "Frank Darabont",
        "imgUrl": "https://img3.doubanio.com/img/celebrity/medium/230.jpg",
        "type": "导演",
        "movieId": 1
      },
      {
        "id": 2,
        "zhName": "蒂姆·罗宾斯",
        "enName": "Tim Robbins",
        "imgUrl": "https://img3.doubanio.com/img/celebrity/large/17525.jpg",
        "type": "主演",
        "movieId": 1
      }
    ]
  }
}
```

## 影院列表页接口

### 获取某电影的影院列表

+ 接口：`/api/cinema/get-cinema-list`
+ 调用要求：无
+ 方法：GET
+ 请求类型：`application/json`
+ 参数含义：
`movie_id`：电影的id
`viewing_date`：观影日期，格式"yyyy-mm-dd"
+ 调用示例：

```bash
http://localhost:8080/api/cinema/get-cinema-list?movie_id=1&&viewing_date=2016-05-29
```
+ 返回示例

```bash
{
  "statusCode": 200,
  "statusInfo": "OK",
  "data": [
    {
      "movieToCinemaId": 1,
      "hasDiscount": true,
      "cinemaInfo": {
        "id": 1,
        "name": "GoGo新天地店",
        "address": "广州大学城新天地二楼"
      }
    }
  ]
}
```

## 场次列表页接口

### 获取场次列表

+ 接口：`/api/showtime/get-showtime-list`
+ 调用要求：无
+ 方法：GET
+ 请求类型：`application/json`
+ 参数含义：
`movie_to_cinema_id`：即之前返回的movieToCinemaId
+ 调用示例：

```bash
http://localhost:8080/api/showtime/get-showtime-list?movie_to_cinema_id=1
```
+ 返回示例

```bash
{
  "statusCode": 200,
  "statusInfo": "OK",
  "data": [
    {
      "showtimeId": 1,
      "startTime": "08:30",
      "roomType": "3D",
      "price": 25
    },
    {
      "showtimeId": 2,
      "startTime": "09:30",
      "roomType": "3D",
      "price": 25
    },
    {
      "showtimeId": 3,
      "startTime": "10:30",
      "roomType": "3D",
      "price": 25
    },
    {
      "showtimeId": 4,
      "startTime": "11:30",
      "roomType": "3D",
      "price": 25
    }
  ]
}
```

## 选座页接口

### 获取场次详情信息

+ 接口：`/api/showtime/get-showtime-info`
+ 调用要求：无
+ 方法：GET
+ 请求类型：`application/json`
+ 参数含义：
`showtime_id`：即之前返回的showtimeId
+ 调用示例：

```bash
http://localhost:8080/api/showtime/get-showtime-info?showtime_id=1
```
+ 返回示例

```bash
{
  "statusCode": 200,
  "statusInfo": "OK",
  "data": {
    "id": 1,
    "startTime": "08:30",
    "roomType": "3D",
    "price": 25,
    "row": 10,
    "col": 10,
    "seatStatus": "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
    "movieToCinemaId": 1
  }
}
```

### 预定座位
+ 接口：`/api/showtime/reserve`
+ 调用要求：HTTP基本认证
+ 方法：POST
+ 请求类型：`application/json`
+ 参数含义：
`showtime_id`：即之前返回的showtimeId
`seat_status`：新的座位信息表, 0表示没人，1表示已经有人，2表示选定状态
+ 调用示例：

```bash
http://localhost:8080/api/showtime/reserve

# 发送的数据
# showtime_id: 1
# seat_status: "2200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
```
+ 返回示例
```bash
# 订票成功
{
  "statusCode": 200,
  "statusInfo": "OK",
  "data": null
}

# 订票失败
{
  "statusCode": 400,
  "statusInfo": "订票失败，座位已经被选",
  "data": null
}
```
