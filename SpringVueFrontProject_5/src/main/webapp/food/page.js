let listApp=Vue.createApp({
    	data() {
    		return {
    			food_list: [],
    			curpage: 1,
    			totalpage: 0,
    			startPage: 0,
    			endPage: 0,
    			type: 1,
    			title: '한식'
    		}
    	},
    	mounted() {
    		this.dataRecv()
    	},
    	methods: {
    		prev() {
    			this.curpage=this.startPage-1
    			this.dataRecv()
    		},
    		next() {
    			this.curpage=this.endPage+1
    			this.dataRecv()
    		},
    		pageChange(page) {
    			this.curpage=page
    			this.dataRecv()
    		},
    		range(start, end) {
    			let arr=[]
    			let len=end-start
    			for(let i=0; i<=len; i++)
    			{
    				arr[i]=start
    				start++;
    			}
    			return arr;
    		},
    		food(type) {
    			this.type=type
    			this.curpage=1
    			this.dataRecv()
    		},
    		dataRecv() {
        		axios.get("http://localhost:8080/web/food/list_vue.do", {
        			params: {
        				page: this.curpage,
        				type: this.type
        			}
        		}).then(res => {
        			console.log(res.data)
        			this.food_list=res.data.list
        			this.title=res.data.title
        			this.curpage=res.data.curpage
        			this.totalpage=res.data.totalpage
        			this.startPage=res.data.startPage
        			this.endPage=res.data.endPage
        		}).catch(error => {
        			console.log(error)
        		})
        	}
    	}
    }).mount(".container")