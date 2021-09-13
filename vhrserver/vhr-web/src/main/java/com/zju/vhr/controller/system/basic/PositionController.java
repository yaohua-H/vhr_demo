package com.zju.vhr.controller.system.basic;

import com.zju.vhr.model.Position;
import com.zju.vhr.model.RespBean;
import com.zju.vhr.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName PositionController
 * @Description
 * @Author Administrator
 * @Date 2021/4/30 15:24
 * @Version
 */
@RestController
@RequestMapping("/system/basic/pos")
public class PositionController {

    @Autowired
    PositionService positionService;

    @GetMapping("/")
    public List<Position> getAllPositions(){
        return positionService.getAllPositions();
    }

    @PostMapping("/")
    public RespBean addPosition(@RequestBody Position position){
        if(positionService.addPosition(position) == 1){
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @PutMapping("/")
    public RespBean updatePositions(@RequestBody Position position){
        if(positionService.updatePositons(position) == 1){
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @DeleteMapping("/{id}")
    public RespBean deletePositionById(@PathVariable Integer id){
        if(positionService.deletePositionById(id) == 1){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @DeleteMapping("/")
    public RespBean deletePositionByIds(Integer[] ids){
        if(positionService.deletePositionsByIds(ids) == ids.length){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }
}
