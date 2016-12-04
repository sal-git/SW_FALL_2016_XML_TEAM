<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:template match="/">
	<xsl:output method="html" encoding="utf-8" version="" indent="yes" standalone="no" media-type="text/html" omit-xml-declaration="no" doctype-system="about:legacy-compat" />

	<html>
		<body>
			<h2 align="center">THE UNIVERSITY OF TEXAS - RIO GRANDE VALLEY</h2>
			<h3 align="center">Degree Type - Bachelor of Science (BS)</h3>
			<h3 align="center">Degree Title - Mathematics</h3>

			<div>
				<p>Mathematics is both an exact science and a highly creative endeavor; a field of study that develops problem‐solving skills and a passion for inquiry. Mathematics majors are surprisingly attractive to many professional branches in our society, particularly intelligence, technology, finance, security, engineering and physics. Mathematics Majors with Teacher Certification are attractive to the growing demand for teachers in high schools, middle schools and elementary schools. A BS in Mathematics will prepare the graduate for a competitive position in society and provide the necessary preparation graduate for an exciting and rewarding teaching position and for graduate studies. </p>
			</div>

			<p></p>

			<div>
			<p><b>STUDENT LEARNING OUTCOMES:</b></p>
				<ol>
					<b>
						<li>Demonstrate in-depth knowledge of Mathematics, its scope, application, history, problems, methods, and usefulness to mankind both as a science and as an intellectual discipline. </li>
						<li>Demonstrate a sound conceptual understanding of Mathematics through the construction of mathematically rigorous and logically correct proofs</li>
						<li>Identify, formulate, and analyze real world problems with statistical or mathematical techniques</li>
						<li>Utilize technology as an effective tool in investigating, understanding, and applying mathematics. </li>
						<li>Communicate mathematics effectively to mathematical and non-mathematical audiences in oral, written, and multi-media form. </li>
						<li>For Middle School and Secondary School Concentrations: <p></p>

							<ol><li>Demonstrate pedagogical content knowledge by successfully completing all state teacher certification requirements. </li></ol>

					  </li>
					</b>
				</ol>
			</div>

			<p></p>

<!-- This is the General Education -->
			<div>
				<ol type="A">
					<li>
						<b>GENERAL EDUCATION CORE (MATH) - 42 HOURS</b>
						<p><i>Students must fulfill the General Education Core requirements. The courses listed below satisfy both degree requirements and General Education core requirements.</i></p>

<!-- This is Required's list -->
						<ul style="list-style-type:none">
						<li><b>REQUIRED: </b></li>

						<p></p>

						<li>
							<ul style="list-style-type:none">
								<li><b>Mathematics - 3 hours</b></li>

								<li>
									<ul style="list-style-type:none">
											<a href="XML/COURSES/math-2413/math-2413.xml"><li>MATH 2413 Calculus I (or MATH 2487 Honors) three-hour lecture</li></a>
									</ul>
								</li>
							</ul>
						</li>
					</ul>

						<p></p>
<!-- This is Recommended List -->
						<li><b>RECOMMENDED: </b></li>

						<p></p>

						<li>
							<ul style="list-style-type:none">
								<li><b>Social and Behavioral Sciences – 3 hours </b></li>

								<li>
									<ul style="list-style-type:none">
												<a href="TEMP/econ-1301.xml"><li>ECON 1301 Intro to Economics</li></a>
												<a href="TEMP/econ-2301.xml"><li>ECON 2301 Principles of Macroeconomics</li></a>
									</ul>
								</li>

<!-- Life and Physical Sciences -->
								<li><b>Life and Physical Sciences – 6 hours </b></li>

								<p></p>

								<li>
									<ul style="list-style-type:none">
												<a href="TEMP/phys-2425.html"><li>PHYS 2425 Physics for Scientist and Engineers I three-hour lecture</li></a>
												<a href="TEMP/phys-2426l.html"><li>PHYS 2426 Physics for Scientist and Engineers II three-hour lecture </li></a>
									</ul>
								</li>

<!-- Integrative and Experiential Learning -->
								<li><b>Integrative and Experiential Learning – 5 hours</b></li>

								<p></p>

								<li>
									<ul style="list-style-type:none">
												<a href="TEMP/phys-2425.html"><li>PHYS 2425 Physics for Scientists and Engineers I one-hour lab </li></a>
												<a href="TEMP/phys-2426l.html"><li>PHYS 2426 Physics for Scientists and Engineers II one-hour lab</li></a>

												<p></p>

												<i>Choose one: </i>

												<a href="TEMP/csci-1370.html"><li>CSCI/CMPE 1370 Engineering Computer Science I (or CSCI/CMPE 1378 Honors)</li></a>
												<a href="TEMP/csci-1380.html"><li>CSCI 1380 Computer Science I (or CSCI 1387 Honors)</li></a>
									</ul>
								</li>



						  	</ul>
					  	</li>

<!-- Major Requirementes -->
						<li>
							<b>Major Requirements - 78 Hours Minimum (51 advanced minimum)</b>

							<!-- Mathematics Core -->

													<ol>
														<li>
															<b>Mathematics Core – 33 hours (21 advanced))</b>

															<xsl:for-each select="POS/Course">
																<ul style="list-style-type:none">
																	<li>
																		<xsl:if test="Divide[text()='Mathematics Core']">
																			<xsl:variable name="link"><xsl:value-of select="Prefix"/><xsl:text>-</xsl:text><xsl:value-of select="Number"/></xsl:variable>
																				<a href="TEMP/{$link}.html">
																					<xsl:value-of select="Prefix"/><xsl:text> </xsl:text><xsl:value-of select="Number"/><xsl:text> </xsl:text><xsl:value-of select="Name"/>
																		    </a>
																	 </xsl:if>
																 </li>
															</ul>
														</xsl:for-each>
													</li>

													<p></p>

							<!-- Concentrations -->
												<li>
													<b>Concentrations – 45 hours minimum (27 advanced minimum)</b>

														<ul type="a">
															<li>
																<b>Applied Mathematics - 45 hours (33 advanced)</b>

							<!-- Applied math core loop -->

																	 <ol type="1">
																	  	<li>
																				<b>Applied Mathematics Core - 9 hours (9 advanced>)</b>
																			</li>

																		  <li><b>Advanced Mathematics Electives – 18 hours (18 advanced) </b></li>


																		  <li><b>Free Electives – 18 hours (6 advanced) </b></li>
															    </ol>
																</li>
															</ul>
														</li>
													</ol>
												</li>
											</ol>
						</li>

						<p></p>
			</div>
		</body>
	</html>
</xsl:template>
</xsl:stylesheet>
