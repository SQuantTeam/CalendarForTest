<template>
    <div>
        <div class="background">
            <el-card class="card next-date">
                <div slot="header" class="clearfix">
                    <span>下一天是哪一天？</span>
                </div>
                <div class="block">
                    <el-date-picker
                    v-model="next_date_input"
                    type="date"
                    value-format="yyyy-MM-dd"
                    placeholder="选择日期">
                    </el-date-picker>
                </div>
                <el-button type="primary" class="caculate" @click="get_next_date">计算</el-button>
                <span v-show="next_date_result.is_valid">{{next_date_result.year}} 年 {{next_date_result.month}} 月 {{next_date_result.date}} 日</span>
            </el-card>

            <el-card class="card next-date">
                <div slot="header" class="clearfix">
                    <span>两个日期间相差多少天？</span>
                </div>
                <div class="block">
                    <el-date-picker
                    v-model="between_dates"
                    type="daterange"
                    range-separator="至"
                    start-placeholder="开始日期"
                    end-placeholder="结束日期"
                    value-format="yyyy-MM-dd">
                    </el-date-picker>
                </div>
                <el-button type="primary" class="caculate" @click="get_between_dates">计算</el-button>
                <span v-show="between_dates_result.is_valid">{{between_dates_result.counts}} 天 </span>
            </el-card>

            <el-card class="card next-date">
                <div slot="header" class="clearfix">
                    <span>推算几天后的日期？</span>
                </div>
                <div class="block">
                    <el-date-picker
                    v-model="date_after_afewdays"
                    type="date"
                    placeholder="选择日期"
                    value-format="yyyy-MM-dd">
                    </el-date-picker>
                    <el-input type="number" v-model="afew" style="width:30%;float:right"></el-input>
                </div>
                
                <el-button type="primary" class="caculate" @click="get_the_date_after_a_few_days">计算</el-button>
                <span v-show="date_after_afewdays_result.is_valid"> {{date_after_afewdays_result.year}} 年 {{date_after_afewdays_result.month}} 月 {{date_after_afewdays_result.date}} 日</span>

            </el-card>

        </div>
        
    </div>
</template>

<style scoped>
.background {
  position: absolute;
  width: 100%;
  height: 100%;
  background-image: url(../assets/background.jpg);
  background-size: 100% 100%;
  top: 0;
  padding-left: 10%;
  padding-right: 10%;
}

.card {
  width: 400px;
  height: 200px;
  position: relative;
  position: relative;
  margin: 15% 3%;
  opacity: 0.95;
  float: left;
}

.caculate {
  position: relative;
  margin-top: 5%;
  /* margin-left: -40%; */
  margin-right: 5%;
}
</style>


<script>
import axios from "axios";
export default {
  data() {
    return {
      para: ["date", "month", "year"],
      afew: 1,
      next_date_input: "",
      this_day_input: "",
      between_dates: "",
      date_after_afewdays: "",
      next_date_result: {
        year: "",
        month: "",
        date: "",
        is_valid: false
      },
      this_day_result: {
        day: "二"
      },
      date_after_afewdays_result: {
        year: 2012,
        month: 12,
        date: 31,
        is_valid: false,
      },
      between_dates_result: {
        counts: 10,
        is_valid: false
      }
    };
  },
  methods: {
    get_next_date() {
        if (this.next_date_input == '') {
            this.$message.error('忘记输入日期了哦！');
            return
        }
        var next_date_input = this.next_date_input.split("-");
        console.log(typeof this.next_date_input);
        var self = this;
        var year = next_date_input[0];
        var month = next_date_input[1];
        var date = next_date_input[2];
        console.log(year, month, date);

        var result = {
            year: " ",
            month: " ",
            date: " ",
            is_valid: true
        };

        axios
            .get("http://10.0.1.240:8088/calendar/dateOfNextDay", {
            params: { year: year, month: month, day: date },
            headers: {
                "X-Requested-With": "XMLHttpRequest",
                "Access-Control-Allow-Origin": "*"
            }
            })
            .then(function(response) {
            console.log(response);
            result.date = response.data;
            })
            .catch(function(error) {
            alert(error);
            });

        axios
            .get("http://10.0.1.240:8088/calendar/monthOfNextDay", {
            params: { year: year, month: month, day: date },
            headers: {
                "X-Requested-With": "XMLHttpRequest",
                "Access-Control-Allow-Origin": "*"
            }
            })
            .then(function(response) {
            console.log(response);
            result.month = response.data;
            })
            .catch(function(error) {
            alert(error);
            });

        axios
            .get("http://10.0.1.240:8088/calendar/yearOfNextDay", {
            params: { year: year, month: month, day: date },
            headers: {
                "X-Requested-With": "XMLHttpRequest",
                "Access-Control-Allow-Origin": "*"
            }
            })
            .then(function(response) {
            console.log(response);
            result.year = response.data;
            })
            .catch(function(error) {
            alert(error);
            });

        console.log(result);
        this.next_date_result = result;
    },

    get_this_day() {
        console.log(this.next_date_input);
        console.log(this.next_date_input.getDate());
        var self = this;
        var year = this.next_date_input.getYear();
        var month = this.next_date_input.getMonth();
        var date = this.next_date_input.getDate();
        var url = "http://10.0.1.240:8087/HelloAST/calendar/dayOfThisDay";
    },

    get_between_dates() {
        if (this.between_dates == '') {
            this.$message.error('忘记输入日期了哦！');
            return
        }
        var start_date = this.between_dates[0].split('-');
        var end_date = this.between_dates[1].split('-');

        var start_year = start_date[0];
        var start_month = start_date[1];
        var start_day = start_date[2];
        var end_year = end_date[0];
        var end_month = end_date[1];
        var end_day = end_date[2];

        var self = this;
        axios
        .get("http://10.0.1.240:8088/calendar/numOfDaysBetweenTwoDates", {
          params: { start_year: start_year, start_month: start_month, start_day: start_day, end_year: end_year, end_month: end_month, end_day: end_day },
          headers: {
            "X-Requested-With": "XMLHttpRequest",
            "Access-Control-Allow-Origin": "*"
          }
        })
        .then(function(response) {
          console.log(response);
          self.between_dates_result.counts = response.data;
          self.between_dates_result.is_valid = true;
        })
        .catch(function(error) {
          alert(error);
        });
        
        
        console.log(this.between_dates)
    },

    get_the_date_after_a_few_days() {
        if (this.date_after_afewdays == '') {
            this.$message.error('忘记输入日期了哦！');
            return;
        } else if(this.afew<0){
            this.$message.error('请输入一个大于等于零的整数');
            return;
        } else if(this.afew != parseInt(this.afew)) {
            this.$message.error('请输入一个大于等于零的整数');
            return;
        }
        console.log(this.date_after_afewdays)
        // getTheDateAfterAFewDays
        var date = this.date_after_afewdays.split('-');
        var year = date[0];
        var month = date[1];
        var day = date[2];
        var num = this.afew;
        var self = this;
        console.log(year, month, day, num)
        axios
        .get("http://10.0.1.240:8088/calendar/dateAfterAFewDays", {
            params: { year: year, month: month, day: day, num: num },
            headers: {
                "X-Requested-With": "XMLHttpRequest",
                "Access-Control-Allow-Origin": "*"
            }
        })
        .then(function(response) {
            console.log(response);
            var result = response.data.split('-');
            self.date_after_afewdays_result.year = result[0];
            self.date_after_afewdays_result.month = result[1];
            self.date_after_afewdays_result.date = result[2];
            self.date_after_afewdays_result.is_valid = true;
        })
        .catch(function(error) {
            alert(error);
        });
    }
  }
};
</script>

