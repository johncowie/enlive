(ns net.cgrand.enlive-html.examples
  (:use [net.cgrand.enlive-html :as html :only [deftemplate at]]))

(deftemplate microblog-template
 "net/cgrand/enlive_html/example.html"  
 [title posts] 
  [:title] (content title)
  [:h1] (content title)
  [:div.no-msg] #(when (empty? posts) %) 
  [:div.post] #(for [{:keys [title body]} posts]
                 (at %
                   [:h2] (content title)
                   [:p] (content body))))
              


(comment
  (apply str (microblog-template "Hello user!" 
               [{:title "post #1" 
                 :body "hello with dangerous chars: <>&"}
                {:title "post #2" 
                 :body "dolor ipsum"}])))
 