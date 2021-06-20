package gdcp.service;

import gdcp.domain.Architect;
import gdcp.domain.Designer;
import gdcp.domain.Employee;
import gdcp.domain.Programmer;

/**
 * @author WeiLiang
 * @date 2021/6/20 - 20:10
 */
//关于开发团队管理添加删除
public class TeamService {
    private static int counter=1;//给memberID赋值使用
    private final int MAX_MAMBER=5;//限制开发团队人数
    private Programmer[] team=new Programmer[MAX_MAMBER];//保存开发团队成员
    private int total;//记录开发团队实际人数

    public TeamService() {
    }
    //获取开发团队所有成员
    public Programmer[] getTeam(){
        Programmer[] team=new Programmer[total];
        for (int i = 0; i < team.length; i++) {
            team[i]=this.team[i];
        }
        return team;
    }
    //添加成员
    public void addMember(Employee e) throws TeamException {
        //团队满了添加不了
        if (total>=MAX_MAMBER){
            throw new TeamException("成员满了无法添加");
        }
        //不是开发人员
        if (!(e instanceof Programmer)){
            throw new TeamException("不是开发成员");
        }
        //已经在开发团队中
        if(isExist(e)){
            throw new TeamException("已经是是开发团队成员");
        }
        //已经是某团队成员
        Programmer p=(Programmer) e;//一定不会出现ClassCastException被开发人员判断过滤了
        String s = p.getStatus().toString();
        if ("BUSY".equals(s)){
            throw new TeamException("已经是某团队成员");
        }else if("VOCATION".equalsIgnoreCase(s)){
            throw new TeamException("休假");
        }
        //获取team已有成员中的架构师，设计师，程序员人数
        int numOfArch=0,numOfDes=0,nuOfPro=0;
        //最多一名架构师
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect){
                numOfArch++;
            }else if (team[i] instanceof Designer){
                numOfDes++;
            }else if(team[i] instanceof Programmer){
                nuOfPro++;
            }
        }
        if (p instanceof Architect){
            if (numOfArch>=1){
                throw new TeamException("最多一名架构师");
            }
        }else if (p instanceof Designer){
            if (numOfDes>=2){
                throw new TeamException("最多两名设计师");
            }
        }else if (p instanceof Programmer){
            if (nuOfPro>=3){
                throw new TeamException("最多三名程序员");
            }
        }//两名设计师
        //三名程序员
        //将p(或e)添加到现有的team中
        team[total++]=p;
        //p的属性赋值
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);


    }
//判断员工是否已经存在现有开发团队中
    private boolean isExist(Employee e) {
        for (int i = 0; i < total; i++) {
            if (team[i].getId()==e.getId()){
                return true;
            }
        }
        return false;
    }

    //删除成员
    public void removeMember(int memberId) throws TeamException {
        int i = 0;
        for (; i < total; i++) {
            if (team[i].getMemberId()==memberId){
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        //为找到指定memberId的情况
        if (i==total){
            throw new TeamException("找不到指定员工删除失败");
        }
        //方式一后一个元素覆盖前一个元素，实现删除操作
        for (int j = i+1; j < total; j++) {
            team[j-1]=team[j];
        }
        //方式二
//        for (int j = i; j < total-1; j++) {
//            team[j]=team[j+1];
//        }
        //写法一;
        /*team[total-1]=null;
        total--;*/
        team[--total]=null;

    }

}
