const menu = {
    list() {
        return [{
            "backMenu": [{
                "child": [{
                    "appFrontIcon": "cuIcon-clothes",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "用户",
                    "menuJump": "列表",
                    "tableName": "yonghu"
                }],
                "menu": "用户管理"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-flashlightopen",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "商家",
                    "menuJump": "列表",
                    "tableName": "shangjia"
                }],
                "menu": "商家管理"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-brand",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "海鲜分类",
                    "menuJump": "列表",
                    "tableName": "shangpinfenlei"
                }],
                "menu": "海鲜分类管理"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-newshot",
                    "buttons": ["查看", "修改", "删除", "查看评论"],
                    "menu": "海鲜信息",
                    "menuJump": "列表",
                    "tableName": "shangpinxinxi"
                }],
                "menu": "海鲜信息管理"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-copy",
                    "buttons": ["查看", "修改", "删除", "查看评论"],
                    "menu": "抢购活动",
                    "menuJump": "列表",
                    "tableName": "miaoshashangpin"
                }],
                "menu": "抢购活动管理"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-goods",
                    "buttons": ["查看", "删除"],
                    "menu": "已退款订单",
                    "tableName": "orders/已退款"
                }, {
                    "appFrontIcon": "cuIcon-flashlightopen",
                    "buttons": ["查看", "删除"],
                    "menu": "未支付订单",
                    "tableName": "orders/未支付"
                }, {
                    "appFrontIcon": "cuIcon-present",
                    "buttons": ["查看", "删除"],
                    "menu": "已发货订单",
                    "tableName": "orders/已发货"
                }, {
                    "appFrontIcon": "cuIcon-goodsnew",
                    "buttons": ["查看", "发货", "删除"],
                    "menu": "已支付订单",
                    "tableName": "orders/已支付"
                }, {
                    "appFrontIcon": "cuIcon-explore",
                    "buttons": ["查看", "删除", "日销量", "月销量", "品销量", "类销量", "月销额", "日销额", "品销额", "类销额"],
                    "menu": "已完成订单",
                    "tableName": "orders/已完成"
                }, {
                    "appFrontIcon": "cuIcon-pic",
                    "buttons": ["查看", "删除"],
                    "menu": "已取消订单",
                    "tableName": "orders/已取消"
                }],
                "menu": "订单管理"
            },
            {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-group",
                    "buttons": ["查看", "修改", "删除"],
                    "menu": "交流论坛",
                    "tableName": "forum"
                }],
                "menu": "交流论坛"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-news",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "资讯",
                    "tableName": "news"
                }, {
                    "appFrontIcon": "cuIcon-cardboard",
                    "buttons": ["查看", "修改"],
                    "menu": "关于我们",
                    "tableName": "aboutus"
                }, {
                    "appFrontIcon": "cuIcon-form",
                    "buttons": ["查看", "修改"],
                    "menu": "轮播图管理",
                    "tableName": "config"
                }],
                "menu": "系统管理"
            }],
            "frontMenu": [{
                "child": [{
                    "appFrontIcon": "cuIcon-flashlightopen",
                    "buttons": ["查看"],
                    "menu": "海鲜信息列表",
                    "menuJump": "列表",
                    "tableName": "shangpinxinxi"
                }],
                "menu": "海鲜信息模块"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-newshot",
                    "buttons": ["查看"],
                    "menu": "抢购活动列表",
                    "menuJump": "列表",
                    "tableName": "miaoshashangpin"
                }],
                "menu": "抢购活动模块"
            }],
            "hasBackLogin": "是",
            "hasBackRegister": "否",
            "hasFrontLogin": "否",
            "hasFrontRegister": "否",
            "roleName": "管理员",
            "tableName": "users"
        }, {
            "backMenu": [],
            "frontMenu": [{
                "child": [{
                    "appFrontIcon": "cuIcon-flashlightopen",
                    "buttons": ["查看"],
                    "menu": "海鲜信息列表",
                    "menuJump": "列表",
                    "tableName": "shangpinxinxi"
                }],
                "menu": "海鲜信息模块"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-newshot",
                    "buttons": ["查看"],
                    "menu": "抢购活动列表",
                    "menuJump": "列表",
                    "tableName": "miaoshashangpin"
                }],
                "menu": "抢购活动模块"
            }],
            "hasBackLogin": "否",
            "hasBackRegister": "否",
            "hasFrontLogin": "是",
            "hasFrontRegister": "是",
            "roleName": "用户",
            "tableName": "yonghu"
        }, {
            "backMenu": [{
                "child": [{
                    "appFrontIcon": "cuIcon-newshot",
                    "buttons": ["新增", "查看", "修改", "删除", "查看评论"],
                    "menu": "海鲜信息",
                    "menuJump": "列表",
                    "tableName": "shangpinxinxi"
                }],
                "menu": "海鲜信息管理"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-copy",
                    "buttons": ["新增", "查看", "修改", "删除", "查看评论"],
                    "menu": "抢购活动",
                    "menuJump": "列表",
                    "tableName": "miaoshashangpin"
                }],
                "menu": "抢购活动管理"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-goods",
                    "buttons": ["查看", "删除"],
                    "menu": "已退款订单",
                    "tableName": "orders/已退款"
                }, {
                    "appFrontIcon": "cuIcon-flashlightopen",
                    "buttons": ["查看", "删除"],
                    "menu": "未支付订单",
                    "tableName": "orders/未支付"
                }, {
                    "appFrontIcon": "cuIcon-present",
                    "buttons": ["查看", "删除"],
                    "menu": "已发货订单",
                    "tableName": "orders/已发货"
                }, {
                    "appFrontIcon": "cuIcon-goodsnew",
                    "buttons": ["查看", "发货", "删除"],
                    "menu": "已支付订单",
                    "tableName": "orders/已支付"
                }, {
                    "appFrontIcon": "cuIcon-explore",
                    "buttons": ["查看", "删除", "日销量", "月销量", "品销量", "类销量", "月销额", "日销额", "品销额", "类销额"],
                    "menu": "已完成订单",
                    "tableName": "orders/已完成"
                }, {
                    "appFrontIcon": "cuIcon-pic",
                    "buttons": ["查看", "删除"],
                    "menu": "已取消订单",
                    "tableName": "orders/已取消"
                }],
                "menu": "订单管理"
            }],
            "frontMenu": [{
                "child": [{
                    "appFrontIcon": "cuIcon-flashlightopen",
                    "buttons": ["查看"],
                    "menu": "海鲜信息列表",
                    "menuJump": "列表",
                    "tableName": "shangpinxinxi"
                }],
                "menu": "海鲜信息模块"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-newshot",
                    "buttons": ["查看"],
                    "menu": "抢购活动列表",
                    "menuJump": "列表",
                    "tableName": "miaoshashangpin"
                }],
                "menu": "抢购活动模块"
            }],
            "hasBackLogin": "是",
            "hasBackRegister": "是",
            "hasFrontLogin": "否",
            "hasFrontRegister": "否",
            "roleName": "商家",
            "tableName": "shangjia"
        }]    }
}
export default menu;
