import eu.mihosoft.vrl.v3d.parametrics.*;
CSG generate(){
	String type= "brushless"
	if(args==null)
		args=["tl2955 "]
	StringParameter size = new StringParameter(	type+" Default",
										args.get(0),
										Vitamins.listVitaminSizes(type))
	HashMap<String,Object> measurments = Vitamins.getConfiguration( type,size.getStrValue())

	def diameterValue = measurments.diameter	def heightValue = measurments.height	println diameterValue	println heightValue
	CSG part = new Cube().toCSG()   return part
		.setParameter(size)
		.setRegenerate({generate()})
}
return getNut() 