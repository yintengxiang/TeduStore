package cn.tedu.store.controller;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.entity.ResponseResult;
import cn.tedu.store.service.ICartService;
import cn.tedu.store.service.ex.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 张启阳
 * @date 2018/9/9 - 9:38
 */
@Controller
@RequestMapping("/cart")
public class CartController extends BaseController {
    @Autowired
    private ICartService cartService;
    @RequestMapping("/add.do")
    @ResponseBody
    public ResponseResult<Void> handleAddToCart(
            Cart cart,
            HttpSession session) {
        ResponseResult<Void> rr;

        // 获取uid，并封装到cart中
        Integer uid =getuidFromSession(session);
        cart.setUid(uid);

        // 执行添加到购物车
        cartService.addToCart(cart);

        // 创建返回对象
        rr = new ResponseResult<Void>(ResponseResult.STATE_OK);

        // 返回
        return rr;
    }
    @RequestMapping("/list.do")
    public String showList(Integer page, HttpSession session, ModelMap map){
        //判断page
        if(page==null||page<1){
            page=1;
        }
        //获取uid
        Integer uid=getuidFromSession(session);
        //查询数据
        List<Cart> carts = cartService.getListByUid(uid, page);
        //封装以备转发
        map.addAttribute("carts",carts);
        //执行转发
        return "cart_list";
    }
    @RequestMapping("/change_number.do")
    @ResponseBody
    public ResponseResult<Void> handleChangeNumber(
            Integer num, Integer id, HttpSession session) {
        // 声明返回值
        ResponseResult<Void> rr;
        // 获取uid
        Integer uid =getuidFromSession(session);
        // 执行修改
        try {
            cartService.changeNumber(num, id, uid);
            rr = new ResponseResult<Void>(ResponseResult.STATE_OK);
        } catch(ServiceException e) {
            rr = new ResponseResult<Void>(e);
        }
        // 执行返回
        return rr;
    }

}
