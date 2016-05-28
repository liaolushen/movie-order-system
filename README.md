# API接口列表

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

+ 接口：`/api/index/get-cinema-list`
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
