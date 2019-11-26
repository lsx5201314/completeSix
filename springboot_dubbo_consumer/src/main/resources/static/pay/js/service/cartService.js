//购物车服务层
app.service('cartService',function($http){
	//购物车列表
	this.findCartList=function(){
		return $http.get('mycart/queryMyCartInfo');
	}
	
	//添加商品到购物车
	this.addGoodsToCartList=function(itemId,num){
		return $http.get('mycart/addGoodsToCartList?itemId='+itemId+'&num='+num);
	}
	//求合计数
	this.sum=function(){
		return $http.get('mycart/queryMyCartAllPrice');
	}
	
	//获取当前登录账号的收货地址
	this.findAddressList=function(){
		return $http.get('address/findListByLoginUser');
	}
	this.findMyCartCount=function () {
		return $http.get('mycart/findMyCartCount');
	}
	//提交订单
	this.submitOrder=function(order){
		return $http.post('order/add',order);
	}
	
	
});